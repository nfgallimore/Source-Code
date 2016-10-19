//
//  ViewController.m
//  NoNib
//
//  David J. Malan
//  Harvard University
//  malan@harvard.edu
//
//  Demonstrates a Single View Application with a view implemented without a nib (or storyboard).
//

#import "ViewController.h"


@implementation ViewController


#pragma mark - UIViewController

- (void)loadView
{
    // create view
    self.view = [[UIView alloc] initWithFrame:[UIScreen mainScreen].applicationFrame];
    self.view.backgroundColor = [UIColor whiteColor];
    
    // create text field
    CGRect frame = CGRectMake(20, 20, 280, 31);
    self.textField = [[UITextField alloc] initWithFrame:frame];
    self.textField.autocapitalizationType = UITextAutocapitalizationTypeWords;
    self.textField.autocorrectionType = UITextAutocorrectionTypeNo;
    self.textField.borderStyle = UITextBorderStyleRoundedRect;
    self.textField.contentVerticalAlignment = UIControlContentVerticalAlignmentCenter;
    self.textField.font = [UIFont systemFontOfSize:[UIFont systemFontSize]];
    self.textField.placeholder = @"Name";
    self.textField.returnKeyType = UIReturnKeyGo;
    
    // listen for Did End on Exit
    [self.textField addTarget:self action:@selector(go:) forControlEvents:UIControlEventEditingDidEndOnExit];
    
    // add text field to view
    [self.view addSubview:self.textField];
    
    // create button
    frame = CGRectMake(124, 59, 72, 37);
    UIButton *button = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    button.frame = frame;
    [button setTitle:@"Go" forState:UIControlStateNormal];
    
    // listen for Touch Up Inside
    [button addTarget:self action:@selector(go:) forControlEvents:UIControlEventTouchUpInside];
    
    // add button to view
    [self.view addSubview:button];
}


#pragma mark - UIAlertViewDelegate

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex
{
    // clear text field
    self.textField.text = nil;
}


#pragma mark - Actions

- (void)go:(id)sender
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
