//
//  ViewController.m
//  Nib2
//
//  David J. Malan
//  Harvard University
//  malan@harvard.edu
//
//  Demonstrates a Single View Application with a UIAlertViewDelegate. 
//

#import "ViewController.h"

@implementation ViewController

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex
{
    // clear text field
    self.textField.text = nil;
}

- (void)didPresentAlertView:(UIAlertView *)alertView
{
    [alertView dismissWithClickedButtonIndex:0 animated:NO];
}

- (IBAction)go:(id)sender
{
    // hide keyboard
    [self.textField resignFirstResponder];
    
    // show alert
    NSString *s = [NSString stringWithFormat:@"Hello, %@", self.textField.text];
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Hello" 
													message:s
												   delegate:self 
										  cancelButtonTitle:@"Thanks!" 
										  otherButtonTitles:nil];
	[alert show];
}

@end
