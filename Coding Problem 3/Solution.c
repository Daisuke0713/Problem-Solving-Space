/*
 * Solution.c
 *
 * Get the smallet k-digit number obtained from n
 *
 * ex) 1928365 - 3 --> 1235
 * ex) 10200   - 1 --> 200
 * ex) 10      - 2 --> 0
 */


char* solution(char* number, int digit) {

	if(strlen(number) == digit) {
		return "0";
	}

	char *result;
	int size = strlen(number) - digit; // the size of resulting string
	for(int i = 0; i < size; i++) {
		if(size == strlen(number)) {

		}




		size -= 1;
	}


	// remove the first xsxsx0's

	return "answer";
}

int main() {
	printf(solution("1928365", 3)); //1235
	printf(solution("10200", 1)); //200
}
