//
//  FoundationViewController.m
//  Foundation
//
//  Created by Shawn Arney on 9/7/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "FoundationViewController.h"

@implementation FoundationViewController

@synthesize hangmanImage;
@synthesize hangmanWordLabel;
@synthesize correctWord;
@synthesize wrongLetters;

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

- (BOOL)textField:(UITextField *)textField shouldChangeCharactersInRange:(NSRange)range 
                                    replacementString:(NSString *)string
{

    [self checkHangmanLetter: string];

    [textField resignFirstResponder];
    
    return NO;
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    [textField resignFirstResponder];
    return NO;
}

#pragma mark - hangman logic
- (void) checkHangmanLetter: (NSString *) letterToCheck
{
    bool match = NO;

    NSRange hangmanLetterRange;
    char charToCheck = [letterToCheck characterAtIndex:0];
    for (int i=0; i < self.correctWord.length; i++) {
        char tempString = [self.correctWord characterAtIndex:i];
    
        if (charToCheck == tempString)
        {
            match = YES;
            hangmanLetterRange = NSMakeRange(i, 1); //location, length
            
            self.hangmanWordLabel.text = [self.hangmanWordLabel.text 
                                          stringByReplacingCharactersInRange:hangmanLetterRange withString:letterToCheck]; 
        }
        
    }
    
    if (match == NO)
    {
        self.wrongLetters = [self.wrongLetters stringByReplacingOccurrencesOfString:letterToCheck 
                                                withString: @""];
        
        self.wrongLetters = [self.wrongLetters stringByAppendingString:letterToCheck];
        
        switch (self.wrongLetters.length) {
            case 1:
                self.hangmanImage.image = [UIImage imageNamed:@"hangman_one"];
                break;
            case 2:
                self.hangmanImage.image = [UIImage imageNamed:@"hangman_two"];
                break;
            case 3:
                self.hangmanImage.image = [UIImage imageNamed:@"hangman_three"];
                break;
            case 4:
                self.hangmanImage.image = [UIImage imageNamed:@"hangman_four"];
                break;
            case 5:
                self.hangmanImage.image = [UIImage imageNamed:@"hangman_five"];
                break;
            case 6:
                self.hangmanImage.image = [UIImage imageNamed:@"hangman_complete"];
                break;
                
            default:
                [self setupHangmanWord:self.correctWord];
                break;
        }
    }
    
}

- (void) setupHangmanWord: (NSString *) hangmanWord
{
    self.wrongLetters = @"";
    self.hangmanWordLabel.text = @"";
    self.hangmanImage.image = [UIImage imageNamed:@"hangman_start"];
    
    for (int i=0; i < hangmanWord.length; i++)
    {
        self.hangmanWordLabel.text = [self.hangmanWordLabel.text stringByAppendingString:@"-"];
    }
}


#pragma mark - View lifecycle


// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];
    
    
    self.correctWord = @"colorado";
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
