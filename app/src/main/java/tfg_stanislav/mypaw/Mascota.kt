package tfg_stanislav.mypaw

import android.os.Parcel
import android.os.Parcelable

data class Mascota(
    val foto: Int,
    val nombre: String,
    val imageEspecie: Int,
    val especie: String,
    val imageRaza: Int,
    val raza: String,
    val imageCumpleanyos: Int,
    val cumpleanyos: String,
    val imageColor: Int,
    val color: String,
    val imagePeso: Int,
    val peso: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(this.foto)
        parcel.writeString(this.nombre)
        parcel.writeInt(this.imageEspecie)
        parcel.writeString(this.especie)
        parcel.writeInt(this.imageRaza)
        parcel.writeString(this.raza)
        parcel.writeInt(this.imageCumpleanyos)
        parcel.writeString(this.cumpleanyos)
        parcel.writeInt(this.imageColor)
        parcel.writeString(this.color)
        parcel.writeInt(this.imagePeso)
        parcel.writeString(this.peso)

    }


    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mascota> {
        override fun createFromParcel(parcel: Parcel): Mascota {
            return Mascota(parcel)
        }

        override fun newArray(size: Int): Array<Mascota?> {
            return arrayOfNulls(size)
        }
    }
}
