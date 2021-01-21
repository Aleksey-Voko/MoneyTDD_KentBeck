package tdd.voko;


class Money {
    protected int amount;

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount && getClass().equals(money.getClass());
    }
}


class Dollar extends Money {
    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}


class Franc extends Money {
    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }
}
