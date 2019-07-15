/*
JS HW, part 1:

Fill in the functions and submit them to your repository in a file called JSHWPart1.js
DUE: 5pm Monday, July 15. 
*/
let homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    var x = 0; //first number in the fib sequence
    var y =1; //second number in the fib sequence
    //the third number will equal the first number plus the second number
    let arr = [x, y]; //make an arr with the first 2 numbers in sequence
    if( n <= 2)
    {
        return 1; //return 1 if n if 2 or less
    }
    for(let i = 2; i <= n; i++) //otherwise start at the third number in sequence
    {
        arr[i] = arr[i-1] + arr[i-2]; //next number will equal array at i minus 1 plus array at i minus 2
    }
    return arr[n]; //return number they want
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    //use bubble sort method
    for(let x = 0; x < array.length; x++){
        for(let y = 0; y < array.length-1; y++){
            if(array[x] < array[y]){
                let temp = array[x];
                array[x] = array[y];
                array[y] = temp;
            }
        }
    };
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    let fac = n; //store n
    for(n = n-1; n >= 1; n--){ //lower n by 1 and loop until n is 1
        fac*= n; //multiple n by fac as it progressively gets bigger each loop
    };
    console.log(fac);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    for(let x = 0; x < n; x++){ //loops an unknown amount of n times
        let temp = array[0];
        let i;
        for (i = 0; i < array.length-1; i++){ //rotates the array by 1 
            array[i] = array[i + 1]; 
            
        };
        array[i] = temp;
    };
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
        let bracket = false;
		let charArr = bracketsString.split('');
		let x = 0;
		let y = charArr.length-1;
		let opposite = 'f';
		
		while(x <= y){
			switch(charArr[x]){
			case'{':
				opposite = '}';
				break;
			case '[':
				opposite = ']';
				break;
			case '(':
				opposite = ')';
				break;
			default:
				return false;
			}
			
			if(charArr[y] == opposite){
				bracket = true;
			}
			else{
				bracket = false;
				break;
			}
			
			x++;
			y--;
		}
		console.log(bracket);
};


//YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)

