export const calculate = (num1, num2, operator) => {
    const a = parseFloat(num1);
    const b = parseFloat(num2);

    switch (operator) {
        case 'add':
            return a + b;
        case 'subtract':
            return a - b;
        case 'multiply':
            return a * b;
        case 'divide':
            if (b === 0) {
                return 'Error: Division by zero';
            }
            return a / b;
        default:
            return null;
    }
};