# BACImplementation

*From Wikipedia*

Five-guess algorithm
In 1977, Donald Knuth demonstrated that the codebreaker can solve the pattern in five moves or fewer, using an algorithm that progressively reduces the number of possible patterns.[11] The algorithm works as follows:

Create the set S of 1296 possible codes (1111, 1112 ... 6665, 6666)
Start with initial guess 1122 (Knuth gives examples showing that other first guesses such as 1123, 1234 do not win in five tries on every code)
Play the guess to get a response of coloured and white pegs.
If the response is four colored pegs, the game is won, the algorithm terminates.
Otherwise, remove from S any code that would not give the same response if it (the guess) were the code.
Apply minimax technique to find a next guess as follows: For each possible guess, that is, any unused code of the 1296 not just those in S, calculate how many possibilities in S would be eliminated for each possible colored/white peg score. The score of a guess is the minimum number of possibilities it might eliminate from S. A single pass through S for each unused code of the 1296 will provide a hit count for each coloured/white peg score found; the coloured/white peg score with the highest hit count will eliminate the fewest possibilities; calculate the score of a guess by using "minimum eliminated" = "count of elements in S" - (minus) "highest hit count". From the set of guesses with the maximum score, select one as the next guess, choosing a member of S whenever possible. (Knuth follows the convention of choosing the guess with the least numeric value e.g. 2345 is lower than 3456. Knuth also gives an example showing that in some cases no member of S will be among the highest scoring guesses and thus the guess cannot win on the next turn, yet will be necessary to assure a win in five.)
Repeat from step 3.
Subsequent mathematicians have been finding various algorithms that reduce the average number of turns needed to solve the pattern: in 1993, Kenji Koyama and Tony W. Lai did an exhaustive depth-first search showing that the optimal method could achieve an average of 5625/1296 = 4.3403 turns to solve, with a worst-case scenario of six turns.
