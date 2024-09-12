class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }

    getValue() {
        return this.value;
    }

    setValue(newValue) {
        this.value = newValue;
    }

    getNext() {
        return this.next;
    }

    setNext(next) {
        this.next = next;
    }
}

module.exports = Node;