package iesvdc.segdodam.recyclerviewmotos.Interfaces

import iesvdc.segdodam.recyclerviewmotos.models.Moto

interface InterfaceDao {
    fun getAllMotos(): List<Moto>
}