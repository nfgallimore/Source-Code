//
//  NSString+Formatter.m
//  objCIntro_template
//
//  Created by Shawn Arney on 8/22/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "NSString+Formatter.h"

@implementation NSString (Formatter)

- (NSString *) formattedString
{
    return [NSString stringWithFormat:@"*** %@ ***", self];
}

@end
