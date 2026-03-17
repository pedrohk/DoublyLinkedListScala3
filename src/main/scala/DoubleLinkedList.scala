class DoubleLinkedList[A] {

  private class Node(var value: A) {
    var prev: Node | Null = null
    var next: Node | Null = null
  }

  private var head: Node | Null = null
  private var tail: Node | Null = null
  private var _size: Int = 0

  def size: Int = {
    _size
  }

  def isEmpty: Boolean = {
    _size == 0
  }

  def addFirst(value: A): Unit = {
    val node = new Node(value)

    if (head == null) {
      head = node
      tail = node
    } else {
      node.next = head
      head.asInstanceOf[Node].prev = node
      head = node
    }

    _size += 1
  }

  def addLast(value: A): Unit = {
    val node = new Node(value)

    if (tail == null) {
      head = node
      tail = node
    } else {
      node.prev = tail
      tail.asInstanceOf[Node].next = node
      tail = node
    }

    _size += 1
  }

  def get(index: Int): A = {
    checkIndex(index)
    nodeAt(index).value
  }

  def set(index: Int, value: A): Unit = {
    checkIndex(index)
    val node = nodeAt(index)
    node.value = value
  }

  def insert(index: Int, value: A): Unit = {
    if (index == 0) {
      addFirst(value)
      return
    }

    if (index == _size) {
      addLast(value)
      return
    }

    checkIndex(index)

    val current = nodeAt(index)
    val previous = current.prev.asInstanceOf[Node]
    val node = new Node(value)

    node.prev = previous
    node.next = current

    previous.next = node
    current.prev = node

    _size += 1
  }

  def removeFirst(): A = {
    if (head == null) {
      throw new NoSuchElementException()
    }

    val node = head.asInstanceOf[Node]
    val value = node.value

    head = node.next

    if (head != null) {
      head.asInstanceOf[Node].prev = null
    } else {
      tail = null
    }

    _size -= 1
    value
  }

  def removeLast(): A = {
    if (tail == null) {
      throw new NoSuchElementException()
    }

    val node = tail.asInstanceOf[Node]
    val value = node.value

    tail = node.prev

    if (tail != null) {
      tail.asInstanceOf[Node].next = null
    } else {
      head = null
    }

    _size -= 1
    value
  }

  def remove(index: Int): A = {
    checkIndex(index)

    if (index == 0) {
      return removeFirst()
    }

    if (index == _size - 1) {
      return removeLast()
    }

    val node = nodeAt(index)
    val prev = node.prev.asInstanceOf[Node]
    val next = node.next.asInstanceOf[Node]

    prev.next = next
    next.prev = prev

    _size -= 1
    node.value
  }

  def contains(value: A): Boolean = {
    var current = head

    while (current != null) {
      if (current.asInstanceOf[Node].value == value) {
        return true
      }
      current = current.asInstanceOf[Node].next
    }

    false
  }

  def indexOf(value: A): Int = {
    var current = head
    var index = 0

    while (current != null) {
      if (current.asInstanceOf[Node].value == value) {
        return index
      }

      current = current.asInstanceOf[Node].next
      index += 1
    }

    -1
  }

  def clear(): Unit = {
    head = null
    tail = null
    _size = 0
  }

  private def nodeAt(index: Int): Node = {
    if (index < _size / 2) {
      var current = head.asInstanceOf[Node]
      var i = 0

      while (i < index) {
        current = current.next.asInstanceOf[Node]
        i += 1
      }

      current
    } else {
      var current = tail.asInstanceOf[Node]
      var i = _size - 1

      while (i > index) {
        current = current.prev.asInstanceOf[Node]
        i -= 1
      }

      current
    }
  }

  private def checkIndex(index: Int): Unit = {
    if (index < 0 || index >= _size) {
      throw new IndexOutOfBoundsException()
    }
  }

  def iterator: Iterator[A] = {
    new Iterator[A] {

      private var current = head

      override def hasNext: Boolean = {
        current != null
      }

      override def next(): A = {
        val node = current.asInstanceOf[Node]
        current = node.next
        node.value
      }

    }
  }

  override def toString: String = {
    val sb = new StringBuilder("[")
    var current = head

    while (current != null) {
      sb.append(current.asInstanceOf[Node].value)
      current = current.asInstanceOf[Node].next
      if (current != null) {
        sb.append(", ")
      }
    }

    sb.append("]")
    sb.toString
  }

}