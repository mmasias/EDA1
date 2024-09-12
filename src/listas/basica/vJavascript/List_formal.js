const Node = require('./Node_formal');

class List {
    constructor() {
        this.first = null;
    }

    size() {
        let count = 0;
        let iterator = this.first;
        while (iterator !== null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    isEmpty() {
        return this.size() === 0;
    }

    insertEnd(value) {
        const newNode = new Node(value);
        if (this.first === null) {
            this.first = newNode;
        } else {
            let iterator = this.first;
            while (iterator.next !== null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }

    insertFront(value) {
        const newNode = new Node(value);
        newNode.next = this.first;
        this.first = newNode;
    }

    delete() {
        if (this.first !== null) {
            let iterator = this.first;
            let previous = null;
            while (iterator.next !== null) {
                previous = iterator;
                iterator = iterator.next;
            }
            if (previous) {
                previous.next = null;
            } else {
                this.first = null;
            }
        }
    }

    listAll() {
        const list = [];
        let iterator = this.first;
        while (iterator !== null) {
            list.push(iterator.value);
            iterator = iterator.next;
        }
        return list;
    }
}

module.exports = List;
