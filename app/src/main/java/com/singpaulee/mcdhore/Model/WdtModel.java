package com.singpaulee.mcdhore.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS on 02/01/2018.
 */

public class WdtModel implements Parcelable {
	Double wdq, wd1, wd2, wd3, wd4, wd5, wd6;

	public WdtModel(Double wdq, Double wd1, Double wd2, Double wd3, Double wd4, Double wd5) {
		this.wdq = wdq;
		this.wd1 = wd1;
		this.wd2 = wd2;
		this.wd3 = wd3;
		this.wd4 = wd4;
		this.wd5 = wd5;
	}

	public WdtModel(Double wdq, Double wd1, Double wd2, Double wd3, Double wd4, Double wd5, Double wd6) {
		this.wdq = wdq;
		this.wd1 = wd1;
		this.wd2 = wd2;
		this.wd3 = wd3;
		this.wd4 = wd4;
		this.wd5 = wd5;
		this.wd6 = wd6;
	}

	protected WdtModel(Parcel in) {
		if (in.readByte() == 0) {
			wdq = null;
		} else {
			wdq = in.readDouble();
		}
		if (in.readByte() == 0) {
			wd1 = null;
		} else {
			wd1 = in.readDouble();
		}
		if (in.readByte() == 0) {
			wd2 = null;
		} else {
			wd2 = in.readDouble();
		}
		if (in.readByte() == 0) {
			wd3 = null;
		} else {
			wd3 = in.readDouble();
		}
		if (in.readByte() == 0) {
			wd4 = null;
		} else {
			wd4 = in.readDouble();
		}
		if (in.readByte() == 0) {
			wd5 = null;
		} else {
			wd5 = in.readDouble();
		}
		if (in.readByte() == 0) {
			wd6 = null;
		} else {
			wd6 = in.readDouble();
		}
	}

	public static final Creator<WdtModel> CREATOR = new Creator<WdtModel>() {
		@Override
		public WdtModel createFromParcel(Parcel in) {
			return new WdtModel(in);
		}

		@Override
		public WdtModel[] newArray(int size) {
			return new WdtModel[size];
		}
	};

	public Double getWd6() {
		return wd6;
	}

	public void setWd6(Double wd6) {
		this.wd6 = wd6;
	}

	public Double getWdq() {
		return wdq;
	}

	public void setWdq(Double wdq) {
		this.wdq = wdq;
	}

	public Double getWd1() {
		return wd1;
	}

	public void setWd1(Double wd1) {
		this.wd1 = wd1;
	}

	public Double getWd2() {
		return wd2;
	}

	public void setWd2(Double wd2) {
		this.wd2 = wd2;
	}

	public Double getWd3() {
		return wd3;
	}

	public void setWd3(Double wd3) {
		this.wd3 = wd3;
	}

	public Double getWd4() {
		return wd4;
	}

	public void setWd4(Double wd4) {
		this.wd4 = wd4;
	}

	public Double getWd5() {
		return wd5;
	}

	public void setWd5(Double wd5) {
		this.wd5 = wd5;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		if (wdq == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(wdq);
		}
		if (wd1 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(wd1);
		}
		if (wd2 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(wd2);
		}
		if (wd3 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(wd3);
		}
		if (wd4 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(wd4);
		}
		if (wd5 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(wd5);
		}
		if (wd6 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(wd6);
		}
	}
}
