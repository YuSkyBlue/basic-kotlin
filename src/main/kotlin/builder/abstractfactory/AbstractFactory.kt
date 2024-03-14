package org.example.patterns.abstractfactory

interface Plant

class OrangePlant : Plant {
    init {
        println("OrgangePlant MAKE")
    }
}

class ApplePlant : Plant

abstract class PlantFactory{

    abstract fun makePlan() : Plant

    companion object{
        inline fun<reified T : Plant> createFactory() : PlantFactory =
            when(T::class){
                OrangePlant::class -> OrangeFactory()
                ApplePlant::class -> AppleFactory()
                else -> throw IllegalArgumentException()
        }
    }
}

class AppleFactory : PlantFactory(){
    override fun makePlan(): Plant {
       return ApplePlant()
    }

}
class OrangeFactory : PlantFactory(){
    override fun makePlan(): Plant {
        return OrangePlant()
    }
}

private fun main(){
    val plantFactory = PlantFactory.createFactory<OrangePlant>()
    println("Create Plant ${plantFactory.makePlan()}")

}