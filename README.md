Features Implemented:
1. storeurl - Save URL with a unique short key and count.
2. get - Return the unique short key after incrementing the usage count.
3. count - Return the latest usage count for a URL.
4. list - Return all URLs and counts in JSON.
5. exit - Terminate the program.

Architecture and Design Documentation:
The program follows a command-line interface (CLI) design. It uses a simple in-memory map to store URLs with their short keys and usage counts. The main components include:
- Main class: UrlDatabase.java
- Command processing: processCommand() method
- URL storage: storeUrl(), getUrl(), getCount() methods
- Short key generation: generateShortKey() method


