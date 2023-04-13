package tfg_stanislav.mypaw

import android.os.Parcel
import android.os.Parcelable

data class Clinica(val image: Int, val name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
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
