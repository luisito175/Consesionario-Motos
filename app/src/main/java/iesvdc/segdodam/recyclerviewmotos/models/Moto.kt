package iesvdc.segdodam.recyclerviewmotos.models

class Moto (
    var marca: String,
    var modelo: String,
    var caracteristicas: String,
    var imagen : String
) {
    override fun toString(): String {
        return "Moto(marca='$marca', modelo='$modelo', caracteristicas='$caracteristicas', imagen='$imagen')"
    }

}
