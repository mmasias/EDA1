from Node_mugre import Node

class List:
    def __init__(self):
        self.first = None

    def size(self):
        count = 0
        iterator = self.first
        while iterator:
            count += 1
            iterator = iterator.next
        return count

    def is_empty(self):
        return self.first is None

    def insert_end(self, value):
        new_node = Node(value)
        if not self.first:
            self.first = new_node
        else:
            iterator = self.first
            while iterator.next:
                iterator = iterator.next
            iterator.next = new_node

    def insert_front(self, value):
        new_node = Node(value)
        new_node.next = self.first
        self.first = new_node

    def delete(self):
        if self.first:
            if not self.first.next:
                self.first = None
            else:
                iterator = self.first
                while iterator.next.next:
                    iterator = iterator.next
                iterator.next = None

    def list_all(self):
        items = []
        iterator = self.first
        while iterator:
            items.append(iterator.value)
            iterator = iterator.next
        return items
