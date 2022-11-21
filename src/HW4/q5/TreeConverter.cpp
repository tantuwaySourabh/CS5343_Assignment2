#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>

enum class NodeColor : unsigned char
{
	BLACK = 0,
	RED = 1
};

struct RedBlackNode
{
	RedBlackNode();
	RedBlackNode(int key, NodeColor color);
	~RedBlackNode();
	RedBlackNode *parent = nullptr;
	RedBlackNode *left = nullptr;
	RedBlackNode *right = nullptr;

	NodeColor color = NodeColor::RED;
	int key;

	friend std::ostream &operator<<(std::ostream &os, const RedBlackNode &node);
};

struct TwoFourNode
{
	TwoFourNode();
	~TwoFourNode();

	TwoFourNode *parent = nullptr;
	std::vector<TwoFourNode *> children;
	std::vector<int> keys;

	friend std::ostream &operator<<(std::ostream &os, const TwoFourNode &node);
};

class TreeConverter
{
private:
	static std::unordered_map<TwoFourNode *, RedBlackNode *> m_NodeMap;

public:
	static TwoFourNode *Convert_RB_To_234(RedBlackNode *root);
	static RedBlackNode *Convert_234_To_RB(TwoFourNode *root);

	static void PrintInorder(RedBlackNode *root);
	static void PrintInorder(TwoFourNode *root);

private:
	static void BSTInsert(RedBlackNode *node, RedBlackNode *root);
	static RedBlackNode *Convert_2_Node(TwoFourNode *node);
	static RedBlackNode *Convert_3_Node(TwoFourNode *node);
	static RedBlackNode *Convert_4_Node(TwoFourNode *node);

	static TwoFourNode *ConvertBlackNode(RedBlackNode *node);
	static void TwoFourInsert(TwoFourNode *node, TwoFourNode *root);
};

RedBlackNode::RedBlackNode()
	: key(-1)
{
}

RedBlackNode::RedBlackNode(int key, NodeColor color)
	: key(key), color(color)
{
}

RedBlackNode::~RedBlackNode()
{
	if (left)
	{
		delete left;
	}

	if (right)
	{
		delete right;
	}
}

std::ostream &operator<<(std::ostream &os, const RedBlackNode &node)
{
	os << (node.color == NodeColor::RED ? "RED[" : "BLK[") << node.key << "]";
	return os;
}

TwoFourNode::TwoFourNode()
{
}

TwoFourNode::~TwoFourNode()
{
	for (auto &c : children)
	{
		if (c)
		{
			delete c;
		}
	}
}

std::ostream &operator<<(std::ostream &os, const TwoFourNode &node)
{
	os << "[ ";
	for (const auto &k : node.keys)
	{
		os << k << " ";
	}
	os << "]";

	return os;
}

TwoFourNode *TreeConverter::Convert_RB_To_234(RedBlackNode *root)
{
	if (!root)
	{
		return nullptr;
	}

	std::queue<RedBlackNode *> childrenQueue;
	std::unordered_map<RedBlackNode *, TwoFourNode *> nodeMap;

	childrenQueue.push(root);

	while (childrenQueue.size())
	{
		RedBlackNode *front = childrenQueue.front();
		childrenQueue.pop();

		TwoFourNode *tfNode = nullptr;
		if (front->color == NodeColor::BLACK)
		{
			tfNode = ConvertBlackNode(front);
			nodeMap.emplace(front, tfNode);
		}

		if (front->left)
		{
			if (front->left->color == NodeColor::RED)
			{
				nodeMap.emplace(front->left, tfNode);
				if (front->left->left)
				{
					childrenQueue.push(front->left->left);
				}
				if (front->left->right)
				{
					childrenQueue.push(front->left->right);
				}
			}
			else
			{
				childrenQueue.push(front->left);
			}
		}

		if (front->right)
		{
			if (front->right->color == NodeColor::RED)
			{
				nodeMap.emplace(front->right, tfNode);
				if (front->right->left)
				{
					childrenQueue.push(front->right->left);
				}
				if (front->right->right)
				{
					childrenQueue.push(front->right->right);
				}
			}
			else
			{
				childrenQueue.push(front->right);
			}
		}

		if (front->parent)
		{
			auto p = nodeMap.find(front->parent);
			if (p != nodeMap.end())
			{
				TwoFourInsert(tfNode, p->second);
			}
		}
	}
	return nodeMap.at(root);
}

RedBlackNode *TreeConverter::Convert_234_To_RB(TwoFourNode *root)
{
	if (!root)
	{
		return nullptr;
	}
	std::queue<TwoFourNode *> childrenQueue;
	std::unordered_map<TwoFourNode *, RedBlackNode *> nodeMap;

	childrenQueue.push(root);

	while (childrenQueue.size())
	{
		TwoFourNode *front = childrenQueue.front();
		childrenQueue.pop();
		RedBlackNode *rbParent = nullptr;
		switch (front->keys.size())
		{
		case 0:
			return nullptr;
		case 1:
		{
			rbParent = Convert_2_Node(front);
			nodeMap.emplace(front, rbParent);
			break;
		}
		case 2:
		{
			rbParent = Convert_3_Node(front);
			nodeMap.emplace(front, rbParent);
			break;
		}
		case 3:
		{
			rbParent = Convert_4_Node(front);
			nodeMap.emplace(front, rbParent);
			break;
		}
		default:
			break;
		}

		if (front->parent)
		{
			const auto &p = nodeMap.find(front->parent);
			if (p != nodeMap.end())
			{
				BSTInsert(rbParent, p->second);
			}
		}

		for (auto &c : front->children)
		{
			if (c)
			{
				childrenQueue.push(c);
			}
		}
	}

	return nodeMap.at(root);
}

void TreeConverter::PrintInorder(RedBlackNode *root)
{
	if (!root)
	{
		return;
	}

	PrintInorder(root->left);

	std::cout << *root << " ";

	PrintInorder(root->right);
}

void TreeConverter::PrintInorder(TwoFourNode *root)
{
	if (!root)
	{
		return;
	}

	PrintInorder(root->children[0]);
	std::cout << root->keys[0] << " ";
	PrintInorder(root->children[1]);

	const int keysSize = root->keys.size();

	if (keysSize > 1)
	{
		std::cout << root->keys[1] << " ";
		PrintInorder(root->children[2]);
	}

	if (keysSize > 2)
	{
		std::cout << root->keys[2] << " ";
		PrintInorder(root->children[3]);
	}
}

void TreeConverter::BSTInsert(RedBlackNode *node, RedBlackNode *root)
{
	if (!node)
	{
		return;
	}
	RedBlackNode *currNode = root;
	while (true)
	{
		if (node->key > currNode->key)
		{
			if (currNode->right)
			{
				currNode = currNode->right;
			}
			else
			{
				currNode->right = node;
				node->parent = currNode;
				break;
			}
		}
		else if (node->key < currNode->key)
		{
			if (currNode->left)
			{
				currNode = currNode->left;
			}
			else
			{
				currNode->left = node;
				node->parent = currNode;
				break;
			}
		}
	}
}

RedBlackNode *TreeConverter::Convert_2_Node(TwoFourNode *node)
{
	RedBlackNode *rbNode = new RedBlackNode(node->keys[0], NodeColor::BLACK);
	return rbNode;
}

RedBlackNode *TreeConverter::Convert_3_Node(TwoFourNode *node)
{
	RedBlackNode *rbParent = new RedBlackNode(node->keys[1], NodeColor::BLACK);
	RedBlackNode *rbChild = new RedBlackNode(node->keys[0], NodeColor::RED);
	rbParent->left = rbChild;
	rbChild->parent = rbParent;
	return rbParent;
}

RedBlackNode *TreeConverter::Convert_4_Node(TwoFourNode *node)
{
	RedBlackNode *rbParent = new RedBlackNode(node->keys[1], NodeColor::BLACK);
	RedBlackNode *rbLeftChild = new RedBlackNode(node->keys[0], NodeColor::RED);
	RedBlackNode *rbRightChild = new RedBlackNode(node->keys[2], NodeColor::RED);

	rbParent->left = rbLeftChild;
	rbLeftChild->parent = rbParent;

	rbParent->right = rbRightChild;
	rbRightChild->parent = rbParent;

	return rbParent;
}

TwoFourNode *TreeConverter::ConvertBlackNode(RedBlackNode *node)
{
	TwoFourNode *tfNode = new TwoFourNode();
	// 4-node
	if (node->left && node->left->color == NodeColor::RED && node->right && node->right->color == NodeColor::RED)
	{
		tfNode->keys.push_back(node->left->key);
		tfNode->keys.push_back(node->key);
		tfNode->keys.push_back(node->right->key);

		tfNode->children.push_back(nullptr);
		tfNode->children.push_back(nullptr);
		tfNode->children.push_back(nullptr);
		tfNode->children.push_back(nullptr);
	}
	// 3-node
	else if (node->left && node->left->color == NodeColor::RED)
	{
		tfNode->keys.push_back(node->left->key);
		tfNode->keys.push_back(node->key);

		tfNode->children.push_back(nullptr);
		tfNode->children.push_back(nullptr);
		tfNode->children.push_back(nullptr);
	}
	// 2-node
	else
	{
		tfNode->keys.push_back(node->key);

		tfNode->children.push_back(nullptr);
		tfNode->children.push_back(nullptr);
	}

	return tfNode;
}

void TreeConverter::TwoFourInsert(TwoFourNode *node, TwoFourNode *root)
{
	if (!node || !root)
	{
		return;
	}

	const int rootKeyCount = root->keys.size();
	const int maxNodeKey = node->keys[node->keys.size() - 1];
	int index = 0;
	for (const auto &k : root->keys)
	{
		if (maxNodeKey < k)
		{
			root->children[index] = node;
			break;
		}
		index++;
	}
	if (index == rootKeyCount)
	{
		root->children[index] = node;
	}
	node->parent = root;
}

int main()
{
	TwoFourNode *root = new TwoFourNode();

	root->keys.push_back(37);

	TwoFourNode *node1 = new TwoFourNode();
	node1->keys.push_back(30);
	node1->keys.push_back(34);

	root->children.push_back(node1);
	node1->parent = root;

	TwoFourNode *node2 = new TwoFourNode();
	node2->keys.push_back(48);
	node2->keys.push_back(60);
	node2->keys.push_back(82);

	root->children.push_back(node2);
	node2->parent = root;

	TwoFourNode *node3 = new TwoFourNode();
	node3->keys.push_back(5);
	node3->children.push_back(nullptr);
	node3->children.push_back(nullptr);

	node1->children.push_back(node3);
	node3->parent = node1;

	TwoFourNode *node4 = new TwoFourNode();
	node4->keys.push_back(32);
	node4->keys.push_back(33);

	node4->children.push_back(nullptr);
	node4->children.push_back(nullptr);
	node4->children.push_back(nullptr);

	node1->children.push_back(node4);
	node4->parent = node1;

	TwoFourNode *node5 = new TwoFourNode();
	node5->keys.push_back(35);
	node5->children.push_back(nullptr);
	node5->children.push_back(nullptr);

	node1->children.push_back(node5);
	node5->parent = node1;

	TwoFourNode *node6 = new TwoFourNode();
	node6->keys.push_back(40);
	node6->children.push_back(nullptr);
	node6->children.push_back(nullptr);

	node2->children.push_back(node6);
	node6->parent = node2;

	TwoFourNode *node7 = new TwoFourNode();
	node7->keys.push_back(50);
	node7->keys.push_back(53);
	node7->keys.push_back(57);

	node7->children.push_back(nullptr);
	node7->children.push_back(nullptr);
	node7->children.push_back(nullptr);
	node7->children.push_back(nullptr);

	node2->children.push_back(node7);
	node7->parent = node2;

	TwoFourNode *node8 = new TwoFourNode();
	node8->keys.push_back(69);
	node8->children.push_back(nullptr);
	node8->children.push_back(nullptr);

	node2->children.push_back(node8);
	node8->parent = node2;

	TwoFourNode *node9 = new TwoFourNode();
	node9->keys.push_back(86);
	node9->keys.push_back(98);
	node9->children.push_back(nullptr);
	node9->children.push_back(nullptr);
	node9->children.push_back(nullptr);

	node2->children.push_back(node9);
	node9->parent = node2;

	std::cout << "Original 2_4 Tree is (Inorder Traversal)) :\n";
	TreeConverter::PrintInorder(root);
	std::cout << "\n\n";

	RedBlackNode *newRoot = TreeConverter::Convert_234_To_RB(root);

	std::cout << "Converting Original 2_4 Tree to Red Black Tree(Inorder Traversal): \n";
	TreeConverter::PrintInorder(newRoot);
	std::cout << "\n\n";

	TwoFourNode *convertedRoot = TreeConverter::Convert_RB_To_234(newRoot);

	std::cout << "Now converting resulting R_B tree to 2_4 tree :\n";
	TreeConverter::PrintInorder(convertedRoot);
	std::cout << "\n\n";

	delete root;
	delete newRoot;
	delete convertedRoot;

	return 0;
}