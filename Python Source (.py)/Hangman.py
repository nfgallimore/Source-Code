# 6.00 Problem Set 3
# 
# Hangman game
#

# -----------------------------------
# Helper code
# You don't need to understand this helper code,
# but you will have to know how to use the functions
# (so be sure to read the docstrings!)

import random
import string

WORDLIST_FILENAME = "/Users/nickgallimore/Cloud/Personal/Dropbox/Personal/Computer Science/Code/Python/ps3/words.txt"

def loadWords():
    """
    Returns a list of valid words. Words are strings of lowercase letters.
    
    Depending on the size of the word list, this function may
    take a while to finish.
    """
    print "Loading word list from file..."
    # inFile: file
    inFile = open(WORDLIST_FILENAME, 'r', 0)
    # line: string
    line = inFile.readline()
    # wordlist: list of strings
    wordlist = string.split(line)
    print '\n\n' + str(len(wordlist)) + " words loaded."
    return wordlist

def chooseWord(wordlist):
    """
    wordlist (list): list of words (strings)

    Returns a word from wordlist at random
    """
    return random.choice(wordlist)

# end of helper code
# -----------------------------------

# Load the list of words into the variable wordlist
# so that it can be accessed from anywhere in the program
wordlist = loadWords()

def isWordGuessed(secretWord, lettersGuessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: boolean, True if all the letters of secretWord are in lettersGuessed;
      False otherwise
    '''
    matched = 0
    for i in range(0, len(secretWord)):
        if lettersGuessed.count(secretWord[i]) > 1:
            matched += 1
        else:
            matched += lettersGuessed.count(secretWord[i])
    if matched == len(secretWord): 
        return True
    else:
        return False



def getGuessedWord(secretWord, lettersGuessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters and underscores that represents
      what letters in secretWord have been guessed so far.
    '''
    word = ''
    for i in range(0, len(secretWord)):
        if isWordGuessed(secretWord[i], lettersGuessed):
            word += secretWord[i]
        else:
            word += '_ '
    return word



def getAvailableLetters(lettersGuessed):
    '''
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters that represents what letters have not
      yet been guessed.
    '''
    word = ''
    import string
    for i in range(0, len(string.ascii_lowercase)):
        if not isWordGuessed(string.ascii_lowercase[i], lettersGuessed ):
            word += string.ascii_lowercase[i] + ' '
    return word 

def hangman(secretWord):
    '''
    secretWord: string, the secret word to guess.

    Starts up an interactive game of Hangman.

    * At the start of the game, let the user know how many 
      letters the secretWord contains.

    * Ask the user to supply one guess (i.e. letter) per round.

    * The user should receive feedback immediately after each guess 
      about whether their guess appears in the computers word.

    * After each round, you should also display to the user the 
      partially guessed word so far, as well as letters that the 
      user has not yet guessed.

    Follows the other limitations detailed in the problem write-up.
    '''
    print '\n\n\n\n\n\n\n\nWelcome to the game, Hangman!'
    print 'I am thinking of a word that is ' + str(len(secretWord)) + ' letters long.'
    lettersGuessed = []
    tries = len(secretWord) * 4
    while tries > 0 or isWordGuessed(secretWord, lettersGuessed):
        print 'You have ' + str(tries) + ' guesses left.'
        tries -= 1
        print getAvailableLetters(lettersGuessed)
        guess = str(raw_input('Please enter your guess: ').lower())
        print '\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n'
        tries += 1
       
        # if player enters invalid letter
        if len(guess) > 1:
            print 'You\'ve entered more than one letter!'
       
        # if letter was already guessed
        if lettersGuessed.count(guess) == 1:
            print 'You\'ve already guessed that letter!'
       
        # if letter hasn't been used yet
        if len(guess) == 1 and lettersGuessed.count(guess) == 0:
            lettersGuessed.append(guess)
       
        # good guess
        if isWordGuessed(guess, secretWord):
            print 'Good guess: ' + getGuessedWord(secretWord, lettersGuessed)
       
        # wrong guess
        if not isWordGuessed(guess, secretWord):
            print 'Oops! The letter \'' + guess + '\' is not in my word: ' + getGuessedWord(secretWord, lettersGuessed)  
       
        # player guessed the secret word
        if isWordGuessed(secretWord, lettersGuessed):
            print '\nCongratulations you guessed:\n' + getGuessedWord(secretWord, lettersGuessed) + '\nin ' + str(len(lettersGuessed)) + ' tries!'
            break
       
        # player ran out of tries
        if tries == 0:
            print 'Sorry you ran out of guesses. The word was ' + secretWord + '.'
            break
            
# When you've completed your hangman function, uncomment these two lines
# and run this file to test! (hint: you might want to pick your own
# secretWord while you're testing)

secretWord = chooseWord(wordlist).lower()
hangman(secretWord)
