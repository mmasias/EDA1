class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, new_value):
        self._value = new_value

    @property
    def next(self):
        return self._next

    @next.setter
    def next(self, next_node):
        self._next = next_node
