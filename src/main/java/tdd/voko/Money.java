package tdd.voko;


abstract class Money {
    protected int amount;
    protected String currency;

    abstract Money times(int multiplier);

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount && getClass().equals(money.getClass());
    }

    String currency() {
        return currency;
    }
}


class Dollar extends Money {
    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    String currency() {
        return currency;
    }

    Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }
}


class Franc extends Money {
    Franc(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    String currency() {
        return currency;
    }

    Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }
}
