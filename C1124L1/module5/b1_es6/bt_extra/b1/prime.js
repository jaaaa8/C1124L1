const isPrime = (num) => {
    if (num <= 1) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) return false;
    }
    return true;
};

console.log(isPrime(7));
console.log(isPrime(10));
console.log(isPrime(2));

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 20, 23];


const primeNumbers = numbers.filter(num => isPrime(num));

console.log("Mảng gốc:", numbers);
console.log("Các số nguyên tố:", primeNumbers);

