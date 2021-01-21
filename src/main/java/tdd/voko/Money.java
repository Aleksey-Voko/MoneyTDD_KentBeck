package tdd.voko;


interface Expression {
    Money reduce(String to);
}

class Bank {
    Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}

class Sum implements Expression {
    Money augend;
    Money addend;

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}

class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount && currency().equals(money.currency());
    }

    String currency() {
        return currency;
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money reduce(String to) {
        return this;
    }
}
