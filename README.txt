Group: Peng Mong Thao (thao0577)
------------------------

Things to know:
------------------------
	- I couldn't really get the results I wanted for the text files but I was getting a bit frustrated so I just turned in what worked best. The hash function works better for different array sizes and different text files.  
 
	- One of the TAs told me I should leave behind some sort of 'proof' to show that I put effort into this. I tried a lot of things but I feel like it'd be too much to show all of it so I here just some of them... 
	
Function #1:	for(int i = 0; i < stringKey.length();i++){
            		hashIdx += stringKey.charAt(i);
        	}
        	hashIdx += (stringKey.charAt(0) + stringKey.charAt(stringKey.length() - 1) + stringKey.charAt(stringKey.length() / 2)) % arr.length;


Function #2: 	for(int i = 0; i < stringKey.length(); i++){   // sums up each character's numerical value in the string and saves it to variable called hashIdx
            		hashIdx += stringKey.charAt(i);
        	}
        	while(hashIdx >= arr.length) {                      // subtracts 98 from the hashIdx until it's < length of array
            		hashIdx -= 98;                                  // tested random numbers and found that 98 worked best
        	}
        	hashIdx = hashIdx - (stringKey.charAt(0) % 5);      // subtracts the 'first character of the string % 5' from hashIdx
        	hashIdx = hashIdx % arr.length;

Function #3: 	for(int i = 0; i < stringKey.length();i++){
            		hashIdx += stringKey.charAt(i);
        	}
		hashIdx = hashIdx - ((hashIdx % 1000) / 100);
		hashIdx = hashIdx % arr.length; 

	- I wasn't sure where I was supposed to read the files in my program so I made two additional methods in my HashTable class where I call a method in the TextScan class which puts all the unique words of the file into an array. Then I call my hash functions on each word. One of the additional methods is for the 'keywords.txt' file while the other one is for all the other files since I also have two different hash functions (one for 'keywords.txt' and one for all the other files). 

-------------------------------
How to run program? Any bugs?:
-------------------------------
	- As far as I know there aren't any bugs in the code and everything should run fine.
	- The main program will run in the HashTable.java file where I've already got tests set up in the main for each file 
	- I've also added in some tests for my add() method
	- My hash function for the 'keywords.txt' file has no collisions with an array size of 322.
	- My hash function for all the other files are not perfect but I tried to make them have only around 10 empty spots 