//
//  tablereorderViewController.m
//  tablereorder
//
//  Created by Shawn Arney on 9/26/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "tablereorderViewController.h"

@implementation tablereorderViewController

@synthesize fruit;

- (void) dealloc
{
    self.fruit = nil;
    [super dealloc];
}


- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - table

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [fruit count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) {
        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier] autorelease];
    }
    
    // Configure the cell...
    
    cell.textLabel.text = [fruit objectAtIndex:indexPath.row]; 
    
    [cell.imageView setImage:
     [UIImage imageNamed:[fruit objectAtIndex:indexPath.row]]
     ];
    
    return cell;       
}

#pragma mark - table editing : delete

- (IBAction)editButtonSelected:(id)sender
{
    
    UIButton *btnEdit = (UIButton *)sender;
    
    if ( [btnEdit.currentTitle isEqualToString:@"Edit"] )
    {
        [btnEdit setTitle:@"Done" forState:UIControlStateNormal];
        [self.tableView setEditing:YES animated:YES];
    }
    else
    {
        [btnEdit setTitle:@"Edit" forState:UIControlStateNormal];
        [self.tableView setEditing:NO animated:YES];
    }
    
}

- (void) tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    
    if (editingStyle == UITableViewCellEditingStyleDelete)
    {
        [self.fruit removeObjectAtIndex:indexPath.row];
        
        [self.tableView deleteRowsAtIndexPaths:[NSArray arrayWithObject:indexPath] withRowAnimation:UITableViewRowAnimationFade];
    }
    
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    if (!self.fruit)
    {
        self.fruit = [NSMutableArray arrayWithObjects:@"cherries", @"grapefruit", @"kiwi", @"muskmelon", @"peach", nil];
    }
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
