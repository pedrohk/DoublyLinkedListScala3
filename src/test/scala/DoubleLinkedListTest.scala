import org.scalatest.funsuite.AnyFunSuite

class DoubleLinkedListTest extends AnyFunSuite {

  test("new list should be empty") {
    val list = new DoubleLinkedList[Int]()
    assert(list.isEmpty)
    assert(list.size == 0)
  }

  test("addFirst should insert at beginning") {
    val list = new DoubleLinkedList[Int]()

    list.addFirst(2)
    list.addFirst(1)

    assert(list.size == 2)
    assert(list.get(0) == 1)
    assert(list.get(1) == 2)
  }

  test("addLast should insert at end") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)

    assert(list.size == 3)
    assert(list.get(2) == 3)
  }

  test("get should return correct value") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(10)
    list.addLast(20)
    list.addLast(30)

    assert(list.get(0) == 10)
    assert(list.get(1) == 20)
    assert(list.get(2) == 30)
  }

  test("set should update value") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)

    list.set(1, 99)

    assert(list.get(1) == 99)
  }

  test("insert should add element in middle") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(3)

    list.insert(1, 2)

    assert(list.size == 3)
    assert(list.get(0) == 1)
    assert(list.get(1) == 2)
    assert(list.get(2) == 3)
  }

  test("removeFirst should remove first element") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)

    val removed = list.removeFirst()

    assert(removed == 1)
    assert(list.size == 1)
    assert(list.get(0) == 2)
  }

  test("removeLast should remove last element") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)

    val removed = list.removeLast()

    assert(removed == 2)
    assert(list.size == 1)
  }

  test("remove should remove element by index") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)

    val removed = list.remove(1)

    assert(removed == 2)
    assert(list.size == 2)
    assert(list.get(1) == 3)
  }

  test("contains should detect element") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(5)
    list.addLast(10)

    assert(list.contains(5))
    assert(!list.contains(99))
  }

  test("indexOf should return correct index") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(7)
    list.addLast(8)
    list.addLast(9)

    assert(list.indexOf(8) == 1)
    assert(list.indexOf(100) == -1)
  }

  test("clear should remove all elements") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)

    list.clear()

    assert(list.isEmpty)
    assert(list.size == 0)
  }

  test("iterator should iterate through list") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)

    val it = list.iterator

    var sum = 0
    while (it.hasNext) {
      sum += it.next()
    }

    assert(sum == 6)
  }

  test("toString should format list correctly") {
    val list = new DoubleLinkedList[Int]()

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)

    assert(list.toString == "[1, 2, 3]")
  }

}