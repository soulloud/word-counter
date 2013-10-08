Comp 124: Word Counting Lab
============

In this lab you'll create a java object called AllWordsCounter who records
counts for individual words.

You'll apply this object to identify distinctive vocabulary for Joe Biden and Sarah Palin
using the 2008 VP debate transcripts.

## Part 1: Preparing

* Fork and clone this project.
* Take a look at the SingleWordCount class, (I've completed it for you).  Make sure you understand every method in the class.
* Take a look at the AllWordsCounter class (you'll be completing this class).  What's the purpose of this class?
* Run the TestSingleWordCounter to make sure you project is setup properly.

## Part 2: Complete the getNumWords and getCount methods in AllWordsCounter

You need to create the array of SingleWordCounter objects, but each
entry in the array will be initially set to null. As you count new words
the array will slowly be filled with actual objects.

* Properly initialize the counters variable for AllWordsClass.
* Implement the count, getNumWords, and getCount methods. I've given you hints.
* Make sure all the tests in AllWordsCounterTests pass except testGetAllWords()

## Part 3: Complete the InterestingWordFinder

In the last step of this project, you'll finish implementing a class (DistinctiveWordFinder) that identifies distinctive
vocabulary in a particular set of document.

* Begin by looking carefully at the interaction of countWords and countWordsInOneFile.
Given the current main() method, what will primaryCounts and secondaryCounts contain at the end?
* In findInterestingWords you'll see two TODOs, and you'll find one additional TODO in getInterestingnessScores.
* Complete the findDistinctive method
* Complete the getDistinctiveScore method in a way that's reasonable to you.
* Tweak your scoring function.
* If you finish, think about ways to speed up your program.
