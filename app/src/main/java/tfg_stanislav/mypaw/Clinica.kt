package tfg_stanislav.mypaw

import android.os.Parcel
import android.os.Parcelable

data class Clinica(val image: Int, val name: String, val imageTlf: Int, val telefono: String, val imageEmail: Int, val email: String, val imageDir: Int, val direccion: String, val imageHora: Int, val horario: String) : Parcelable {
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
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeInt(imageTlf)
        parcel.writeString(telefono)
        parcel.writeInt(imageEmail)
        parcel.writeString(email)
        parcel.writeInt(imageDir)
        parcel.writeString(direccion)
        parcel.writeInt(imageHora)
        parcel.writeString(horario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Clinica> {
        override fun createFromParcel(parcel: Parcel): Clinica {
            return Clinica(parcel)
        }

        override fun newArray(size: Int): Array<Clinica?> {
            return arrayOfNulls(size)
        }
    }
}
