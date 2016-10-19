//
//  FoundationViewController.m
//  Foundation
//
//  Created by Shawn Arney on 9/7/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "FoundationViewController.h"

@implementation FoundationViewController

// (7) synthesize all the properties we added in FoundationViewController.h
@synthesize hangmanImage;
@synthesize hangmanWordLabel;
@synthesize correctWord;
@synthesize wrongLetters;

// (8) setup a function to dealloc all the properties AND super dealloc
- (void) dealloc
{
    [hangmanImage release];
    [hangmanWordLabel release];
    [correctWord release];
    [wrongLetters release];
    
    [super dealloc];
}


- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - text box
- (BOOL)textField:(UITextField *)textField shouldChangeCharactersInRange:(NSRange)range replacementString:(NSString *) string
{
    [self checkHangmanLetter: string];
    
    // closes keyboard after letter is entered
    [textField resignFirstResponder];
    
    // makes textfield uneditable
    return NO;
}


#pragma mark - hangman logic
// (9) checks if users guess is correct
- (void) checkHangmanLetter:(NSString *)letterToCheck
{
    // (10) intializes a bool variable named match to no
    bool match = NO;
    
    // (11) initializes an NSRange named hangmanLetterRange
    NSRange hangmanLetterRange;
    
    // (12) converts the passed in NSString "letterToCheck" into a char
    char charToCheck = [letterToCheck characterAtIndex:0];
    
    // (13) loops through each letter of the correct word
    for (int i = 0; i < self.correctWord.length; i++) 
    {
        // (14) assigns each letter of the correct word to a temp char
        char tempString = [self.correctWord characterAtIndex:i];
        
        // (15) if the users guess was correct
        if  (charToCheck == tempString)
        {
            // (16) set match to YES
            match = YES;
            
            // (17) makes an range at that index location with a length of 1
            hangmanLetterRange = NSMakeRange(i, 1);
            
            // (18) inserts letter that we found into the hangman word label at the i'th index
            self.hangmanWordLabel.text = [self.hangmanWordLabel.text
                                          stringByReplacingCharactersInRange:hangmanLetterRange withString:
                                          letterToCheck];
        }
    }
    // (19) if there is no match
    if (match == NO)
    {
        // (20) makes sure user doesn't input an already incorrectly guessed letter
        self.wrongLetters = [self.wrongLetters stringByReplacingOccurrencesOfString:letterToCheck
                                                                         withString: @""];
        // (21) appends wrong letter to wrong letter string
        self.wrongLetters = [self.wrongLetters stringByAppendingString:letterToCheck];
        
        // (22) if wrong letter string is a certain length displays corresponding hangman image
        switch (self.wrongLetters.length)
        {
            case 1:
                self.hangmanImage.image = [UIImage imageNamed: @"hangman_one"];
                break;
            case 2:
                self.hangmanImage.image = [UIImage imageNamed: @"hangman_two"];
                break;
            case 3:
                self.hangmanImage.image = [UIImage imageNamed: @"hangman_three"];
                break;
            case 4:
                self.hangmanImage.image = [UIImage imageNamed: @"hangman_four"];
                break;
            case 5:
                self.hangmanImage.image = [UIImage imageNamed: @"hangman_five"];
                break;
            case 6:
                self.hangmanImage.image = [UIImage imageNamed: @"hangman_complete"];
                break;
            
            default:
                [self setupHangmanWord:self.correctWord];
                break;
        }
    }
}

// (23) sets up the hangman word
- (void) setupHangmanWord: (NSString *) hangmanWord
{
    
    // (24)resets wrong letters
    self.wrongLetters = @"";
    
    // (25) resets word label to empty
    self.hangmanWordLabel.text = @"";
    
    // (26) resets image
    self.hangmanImage.image = [UIImage imageNamed: @"hangman_start"];
    
    // (27) sets up "-" per the length of the hidden word
    for (int i = 0; i < hangmanWord.length; i++)
    {
        self.hangmanWordLabel.text = [self.hangmanWordLabel.text stringByAppendingString:@"-"];
    }
}




#pragma mark - View lifecycle


// (28) Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];
    
    // (29) sets up correct word
    self.correctWord = @"colorado";
    
    // (30) runs the method setuphangmanword
    [self setupHangmanWord:self.correctWord];
    
}


- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

@end
