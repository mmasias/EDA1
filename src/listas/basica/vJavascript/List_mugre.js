const Node = require('./Node_mugre');

class List {
    constructor() {
        this.first = null;
    }

    size() {
        let count = 0;
        let current = this.first;
        while (current) {
            count++;
            current = current.next;
        }
        return count;
    }

    isEmpty() {
        return this.first === null;
    }

    insertEnd(value) {
        const newNode = new Node(value);
        if (!this.first) {
            this.first = newNode;
        } else {
            let current = this.first;
            while (current.next) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    insertFront(value) {
        const newNode = new Node(value);
        newNode.next = this.first;
        this.first = newNode;
    }

    delete() {
        if (!this.first) return;

        let current = this.first;
        let previous = null;
        while (current.next) {
            previous = current;
            current = current.next;
        }
        if (previous) {
            previous.next = null;
        } else {
            this.first = null;
        }
    }

    listAll() {
        let elements = [];
        let current = this.first;
        while (current) {
            elements.push(current.value);
            current = current.next;
        }
        return elements;
    }
}

module.exports = List;
