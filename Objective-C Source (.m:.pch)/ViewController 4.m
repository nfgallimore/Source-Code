//
//  ViewController.m
//  Nib1
//
//  David J. Malan
//  Harvard University
//  malan@harvard.edu
//
//  Demonstrates a Single View Application implemented with a nib, plus IBAction and IBOutlet.
//

#import "ViewController.h"

@implementation ViewController

- (IBAction)go:(id)sender
{
    // hide keyboard
    [self.textField resignFirstResponder];
    
    // show alert
    NSString *s = [NSString stringWithFormat:@"Hello, %@", self.textField.text];
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Hello" 
													message:s
												   delegate:nil 
										  cancelButtonTitle:@"Thanks!"
										  otherButtonTitles:nil];
	[alert show];
}

@end
