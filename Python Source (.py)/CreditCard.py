balance = int(raw_input('Enter current Balance: '))
annualInterestRate = float(raw_input('Enter Annual Interest Rate: '))
monthlyPaymentRate = float(raw_input('Enter Monthly Payment Rate: '))
monthlyInterestRate = annualInterestRate / 12.0

#Problem 1
paid = 0
remainingBalance = balance
for month in range(1, 13):
    print('Month: ' + str(month))
    print('Mininum monthly payment: %.2f' % (monthlyPaymentRate * remainingBalance) )
    paid += monthlyPaymentRate * remainingBalance
    print('Remaining balance: %.2f' % remainingBalance + '\n')
    remainingBalance -= monthlyPaymentRate * remainingBalance
    remainingBalance += monthlyInterestRate * remainingBalance
print('Total paid: %.2f' % paid)
print('Remaining Balance: %.2f\n' % remainingBalance)

#Problem 2
for payment in range(0, balance, 10):
    unpaidBalance = balance
    for month in range(0, 12):
        unpaidBalance -= payment
        unpaidBalance += monthlyInterestRate * unpaidBalance
    if unpaidBalance > 0:
        payment += 10
    else:
        break
print ('Lowest payment to pay off in 12 months: %.2f\n' % payment)

#Problem 3
lowerbound = balance / 12.0
upperbound = (balance * (1 + monthlyInterestRate)**12.0) / 12.0
payment = lowerbound
while payment < upperbound:
    unpaidBalance = balance
    for month in range(0, 12):
        unpaidBalance -= payment
        unpaidBalance += monthlyInterestRate * unpaidBalance
    if unpaidBalance > 0:
        payment += 0.01
    else:
        break
print ('Lowest payment to pay off in 12 months: %.2f\n' % payment)