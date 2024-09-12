from Node_formal import Node

class List:
    def __init__(self):
        self._first = None

    def size(self):
        count = 0
        iterator = self._first
        while iterator is not None:
            count += 1
            iterator = iterator.next
        return count

    def is_empty(self):
        return self.size() == 0

    def insert_end(self, value):
        new_node = Node(value)
        if not self._first:
            self._first = new_node
        else:
            iterator = self._first
            while iterator.next is not None:
                iterator = iterator.next
            iterator.next = new_node

    def insert_front(self, value):
        new_node = Node(value)
        if not self._first:
            self._first = new_node
        else:
            new_node.next = self._first
            self._first = new_node

    def delete(self):
        if self._first:
            if self._first.next is None:
                self._first = None
            else:
                iterator = self._first
                while iterator.next.next is not None:
                    iterator = iterator.next
                iterator.next = None

    def list_all(self):
        items = []
        iterator = self._first
        while iterator is not None:
            items.append(iterator.value)
            iterator = iterator.next
        return items
