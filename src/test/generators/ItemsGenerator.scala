package generators

import objects.Item
import randomisers.{RandomIntBetween, RandomValueFromFile}

import scala.collection.mutable.ListBuffer

object ItemsGenerator {
  var totalPrice: Int = 0

  def item(basketItemId:Int): Item = Item(
    basketItemId = basketItemId,
    description = RandomValueFromFile("src/test/data/Items.txt"),
    price = RandomIntBetween(minInclusive = 1, maxExclusive = 100)
  )

  def itemsList(numberOfItems:Int): List[Item] = {
    var itemsListBuffer = new ListBuffer[Item]()
    for (itemForLoopIncrement: Int <- 1 to numberOfItems){
      itemsListBuffer += ItemsGenerator.item(itemForLoopIncrement)
    }
    val itemList: List[Item] = itemsListBuffer.toList
    totalPrice = calculateTotalPrice(itemList)
    itemList
  }

  def calculateTotalPrice(itemsList:List[Item]): Int = {
    var sumPrice = 0
    itemsList.foreach{
      item => sumPrice = sumPrice + item.price
    }
    sumPrice
  }
}
