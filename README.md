# CS2341_A3
Assignment 3 for CS2341

<u>Wade Hunter 48839484</u>

<u>Julia Bonsack 48787874</u>


<u>Underlined Section</u>

Reference for RedBlackBST methods was the example in Princetone textbook.

--Product Search (I did 4 and illustrated a not-found)--:

Product ID: 2e2d46cee23bf6e46bcfc3202be60176, Name: Sticko 450188 Stickers, Shimmery Stars, Category: Toys & Games | Arts & Crafts | Stickers, Price: $1.89

Product ID: d1ac6d805fcdf75f9e00af611dd03ce4, Name: The Learning Journey ABC Melody Maker, Primary, Category: Toys & Games | Baby & Toddler Toys | Musical Toys, Price: $34.39

Product ID: 89a993dbc079cc3fbe9088c8170b6f99, Name: PLUS PLUS - Construction Building Toy, Open Play Set - 3,600 Pieces with Storage Tub - Basic Color Mix, Category: Toys & Games | Building Toys | Building Sets, Price: $159.99

Product with ID aNonExistentProductID not found.

--Duplicate Product Insertion (ID: 2e2d46cee23bf6e46bcfc3202be60176)--:

Error: Product with ID 2e2d46cee23bf6e46bcfc3202be60176 already exists.

--Product Insertion--:

Product added: Product ID: 2341ComputerScience, Name: A Widgit, Category: New Category, Price: $50.12

Product added: Product ID: CS2341DataStructures, Name: Hammer, Category: New Category, Price: $2341.99

**Was informed in lab to give a write up regarding time complexity, below is my write-up:**

**Search** time complexity: 2lg(N) (this is the guarenteed complexity) this is because the tree will traverse from the root, and because these trees are forced to have a max height of 2lg(N), the time complexity will take that equivalent.

**Insert** time complexity: 2ln(N), the traversal to arrive at the place where you want to actually insert your value will take that of the max height of a RB-BST (Red-Black Binary Search Tree). For RB-BSTs the time for recoloration and rotations is constant.

<u>I was not required to do any type of deletion in the assignment, but I will give the summary for deletion since it is in our lecture slides:</u>

**Deletion** time complexity: 2lg(N), it will once again be 2lg(N) for RB-BSTs because the the operation is at the max height which is a guarentee.


<u>I also wanted to note the average cases, as listed below:</u>

Search: 1lg(N)

Insert: 1lg(N)

Delete: 1lg(N)

These cases are because on average you will have a RB-BST that isnt as "deep" as the worst case. Even when inserting, deleting, or inserting a key, you won't have to traverse at a really deep part of the tree (like having to insert the deepest value is not the occurance that will happen every time you do an operation, and will not occur often).




