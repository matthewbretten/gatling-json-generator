package objects

case class Basket(
                 customer: Customer,
                 totalPrice : Int,
                 items : List[Item],
                 dateCreated : String
                 )
