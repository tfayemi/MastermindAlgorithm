# BACImplementation

## Introduction

This is a simple application of Donald Knuth's MINMAX 5-Guess Mastermind algorithm as applied to the popular *Bulls and Cows* word game. 

## Donald Knuth's Mastermind

**From Wikipedia**

## Five-guess algorithm

In 1977, Donald Knuth demonstrated that the codebreaker can solve the pattern in five moves or fewer, using an algorithm that progressively reduces the number of possible patterns.[11] The algorithm works as follows:

1. Create the set S of 1296 possible codes (1111, 1112 ... 6665, 6666)
2. Start with initial guess 1122 (Knuth gives examples showing that other first guesses such as 1123, 1234 do not win in five tries on every code)
3. Play the guess to get a response of coloured and white pegs.
4. If the response is four colored pegs, the game is won, the algorithm terminates.
5. Otherwise, remove from S any code that would not give the same response if it (the guess) were the code.
6. Apply minimax technique to find a next guess as follows: For each possible guess, that is, any unused code of the 1296 not just those in S, calculate how many possibilities in S would be eliminated for each possible colored/white peg score. The score of a guess is the minimum number of possibilities it might eliminate from S. A single pass through S for each unused code of the 1296 will provide a hit count for each coloured/white peg score found; the coloured/white peg score with the highest hit count will eliminate the fewest possibilities; calculate the score of a guess by using "minimum eliminated" = "count of elements in S" - (minus) "highest hit count". From the set of guesses with the maximum score, select one as the next guess, choosing a member of S whenever possible. (Knuth follows the convention of choosing the guess with the least numeric value e.g. 2345 is lower than 3456. Knuth also gives an example showing that in some cases no member of S will be among the highest scoring guesses and thus the guess cannot win on the next turn, yet will be necessary to assure a win in five.)
7. Repeat from step 3.

Subsequent mathematicians have been finding various algorithms that reduce the average number of turns needed to solve the pattern: in 1993, Kenji Koyama and Tony W. Lai did an exhaustive depth-first search showing that the optimal method could achieve an average of 5625/1296 = 4.3403 turns to solve, with a worst-case scenario of six turns.

## Bulls And Cows

Bulls and Cows is a classic British pen-and-paper game for two players. In the standard version of this game, one player tries to guess the secret integer chosen by the other player. This secret integer must be such that no digit appears inside it more than once. The guesser submits his guesses for the secret number one guess at the time. After each guess, the opponent reveals how many ​bulls (right digit in the right position) and ​cows (right digit but in a wrong position) that particular guess contains. For example, the guess 7415 contains one bull (the digit 4) and two cows (the digits 1 and 5), whereas the guess 9257 contains one bull (the digit 5) and zero cows. Each guess therefore provides more information about the secret number by eliminating a bunch of numbers that were still possible after the previous guesses.
This project adapts the basic rules of Bulls and Cows from integers to the more interesting domain of English words composed of the lowercase letters ​a-z​, as listed in the file words_alpha.txt​, to create a new game that resembles another classic game called ​Jotto​. Otherwise, the game mechanics are identical to those of the basic integer version of Bulls and Cows. However, when played with the subset of English words in which each letter occurs at most once, the restricted structure of the language and its statistical letter combinations allow the guesses to be made in ways that have a higher chance of guessing the secret word earlier, compared to blindly making random guesses among the words that are still possible given the information gleaned from the previous guesses.

## BACRunner

BACRunner is automated. It runs the game and keeps the score. Testers can modify the number of runs and the "Mercy" limit (the number of guesses the Implimentation is allowed to make before the runner kills the round and calls is a loss, just to ensrue eventual termination should anything go wrong during a run). is played for several rounds to diminish the effect of blind random luck. The total number of guesses made over all these rounds becomes the final score of the player. As in golf, the lower the score, the better.

The variable ​rounds determines how many secret words the game is played for before tallying up the final score. The tester script takes care of filtering of the words that contain duplicated letters, so that the player script does not have to worry about any such words in the given wordlist. In the Java version ​BACRunner.java​, the names for these settings are M​ INLEN​, ​MAXLEN​ and R​ OUNDS​, respectively.
The choice of random secret words is done in ​pseudorandom fashion using the ​seed value defined inside the ​bacrunner.py script, named ​SEED in ​BACRunner.java​. Using a fixed ​seed value, the series of secret words produced by the tester will always be the same in every run. The fact that once the ​seed value has been fixed, all seemingly possible outcomes of the potentially branching future are illusory because the resulting execution is in reality just as deterministic as a train destined to follow its tracks, is actually a very good thing during the development stage! When debugging your script or optimizing its logic and accuracy, the exact same series of secret words can be repeated as often as you need to compare the results of the script before and after each change.
One example run for ten rounds using one of the author's private model solutions produced the following output. After printing out the current parameters, each line first displays the secret word in square brackets, followed by the incorrect guesses made before hitting the secret word. For example, this particular player implementation needed five guesses to hit the secret word blinkers​. The last line of the output displays the total score, followed by the student ID and name information of that player.

## BACImplementation

The implementation of the algorithm is automated. When run, the current play conditions are assessed and - via a rudimentary decision-making tree - words are eliminated from the master list. A suite of methods are used to trim the list and to determine the strongest guess. Finally, the method *public String guess(int n, List<String> guesses, List<Integer> bulls, List<Integer> cows);* returns a final guess to be compared to the "secret word" held privately in the BACRunner code.
  
The tester script calls this function exactly once in the beginning, before commencing the play of the individual rounds. The parameter ​words is the list of English words that could appear as secret words in the game, guaranteed to be in sorted lexicographic order. This wordlist is not passed as an argument to the other functions later in the game, so the player script is supposed to store and remember the wordlist for later use at this stage. This function is also welcome to perform any preprocessing of the wordlist and organizing its content into whatever data structures of your choosing that might later improve the speed and accuracy of guessing.

n Java, due to the lamentable lack of tuples and triples in that language, the ​(word, bulls, cows) information triple is split into three separate lists so that the first list ​guesses contains the list of the previously guessed words. For each such ​word​, the corresponding element in the list ​bulls is the number of bulls in that same word, and similarly for ​cows​. (These three lists always therefore have the exact same size.)
  
  ## Results
  
In this short exercise, Donald Knuth's mastermind algorithm was proven to be transferrable to word games with similar game meahcnics and parameters. My implimentation of Donald Knuth's algorithm was successfully able to guess the "secret word" in an avergae of 5.84 guesses. Nauturally, with a greater range of posisble values, future tests on more expansive lists of applicable words would yeild deeper insights into the nature of the algorithm and our pursuit of optimization. Who said algorithms can't be fun? Oh, nobody? Alright.

## Sources/Further Reading

[The Computer as Mastermind by Donald E. Knuth](https://www.cs.uni.edu/~wallingf/teaching/cs3530/resources/knuth-mastermind.pdf)

[Mastermind Algorithms - Wikipedia](https://en.wikipedia.org/wiki/Mastermind_(board_game)#Algorithms)

[A Mathematical Approach to Simple Bulls and Cows by Namanyay Goel and Aditya Garg](https://vixra.org/pdf/1601.0302v1.pdf)

[Tactile Tools for Teaching: An Implementation of Knuth's Algorithm for Mastering Mastermind by Thomas M. Fiore, Alexander Lang, and Antonella Perucca](http://www.antonellaperucca.net/FioreLangPerucca.pdf)


