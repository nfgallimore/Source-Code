#include <cs50.h>
#include <stdio.h>

int main(int argc, string argv[])
{
	printf("Please give me a number greater than 0 and less than or equal to 23.\n");
	int input = GetInt();

	if (input <= 23 && input > 0) {
        int i;
        for (int n = input; n > 0; n--) {
			for (i = 0; i < input - (input - n); i++) {
				printf(" ");
			}
            for (int k = 0; k < (input - 1); k++) {
        		for (int j = 0; j < input - (input - (input - (input - n))); j++) {
            		printf("#");
        		}
            }
            printf("\n");
        }
	}
}
