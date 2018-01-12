package com.singpaulee.mcdhore.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS on 02/01/2018.
 */

public class TfIdfModel implements Parcelable{
	String term;
	Integer query, dokumen1, dokumen2, dokumen3, dokumen4, dokumen5, dokumen6;
	Integer totalDf;
	Double dfi;
	Double idf;

	public TfIdfModel(String term, Integer query, Integer dokumen1, Integer dokumen2, Integer dokumen3, Integer dokumen4, Integer dokumen5) {
		this.term = term;
		this.query = query;
		this.dokumen1 = dokumen1;
		this.dokumen2 = dokumen2;
		this.dokumen3 = dokumen3;
		this.dokumen4 = dokumen4;
		this.dokumen5 = dokumen5;
	}

	public TfIdfModel(String term, Integer query, Integer dokumen1, Integer dokumen2, Integer dokumen3, Integer dokumen4, Integer dokumen5, Integer dokumen6) {
		this.term = term;
		this.query = query;
		this.dokumen1 = dokumen1;
		this.dokumen2 = dokumen2;
		this.dokumen3 = dokumen3;
		this.dokumen4 = dokumen4;
		this.dokumen5 = dokumen5;
		this.dokumen6 = dokumen6;
	}

	public TfIdfModel(String term, Integer query, Integer dokumen1, Integer dokumen2, Integer dokumen3, Integer dokumen4, Integer dokumen5, Integer totalDf, Double dfi, Double idf) {
		this.term = term;
		this.query = query;
		this.dokumen1 = dokumen1;
		this.dokumen2 = dokumen2;
		this.dokumen3 = dokumen3;
		this.dokumen4 = dokumen4;
		this.dokumen5 = dokumen5;
		this.totalDf = totalDf;
		this.dfi = dfi;
		this.idf = idf;
	}

	public TfIdfModel(String term, Integer query, Integer dokumen1, Integer dokumen2, Integer dokumen3, Integer dokumen4, Integer dokumen5, Integer dokumen6, Integer totalDf, Double dfi, Double idf) {
		this.term = term;
		this.query = query;
		this.dokumen1 = dokumen1;
		this.dokumen2 = dokumen2;
		this.dokumen3 = dokumen3;
		this.dokumen4 = dokumen4;
		this.dokumen5 = dokumen5;
		this.dokumen6 = dokumen6;
		this.totalDf = totalDf;
		this.dfi = dfi;
		this.idf = idf;
	}

	protected TfIdfModel(Parcel in) {
		term = in.readString();
		if (in.readByte() == 0) {
			query = null;
		} else {
			query = in.readInt();
		}
		if (in.readByte() == 0) {
			dokumen1 = null;
		} else {
			dokumen1 = in.readInt();
		}
		if (in.readByte() == 0) {
			dokumen2 = null;
		} else {
			dokumen2 = in.readInt();
		}
		if (in.readByte() == 0) {
			dokumen3 = null;
		} else {
			dokumen3 = in.readInt();
		}
		if (in.readByte() == 0) {
			dokumen4 = null;
		} else {
			dokumen4 = in.readInt();
		}
		if (in.readByte() == 0) {
			dokumen5 = null;
		} else {
			dokumen5 = in.readInt();
		}
		if (in.readByte() == 0) {
			dokumen6 = null;
		} else {
			dokumen6 = in.readInt();
		}
		if (in.readByte() == 0) {
			totalDf = null;
		} else {
			totalDf = in.readInt();
		}
		if (in.readByte() == 0) {
			dfi = null;
		} else {
			dfi = in.readDouble();
		}
		if (in.readByte() == 0) {
			idf = null;
		} else {
			idf = in.readDouble();
		}
	}

	public static final Creator<TfIdfModel> CREATOR = new Creator<TfIdfModel>() {
		@Override
		public TfIdfModel createFromParcel(Parcel in) {
			return new TfIdfModel(in);
		}

		@Override
		public TfIdfModel[] newArray(int size) {
			return new TfIdfModel[size];
		}
	};

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getQuery() {
		return query;
	}

	public void setQuery(Integer query) {
		this.query = query;
	}

	public Integer getDokumen1() {
		return dokumen1;
	}

	public void setDokumen1(Integer dokumen1) {
		this.dokumen1 = dokumen1;
	}

	public Integer getDokumen2() {
		return dokumen2;
	}

	public void setDokumen2(Integer dokumen2) {
		this.dokumen2 = dokumen2;
	}

	public Integer getDokumen3() {
		return dokumen3;
	}

	public void setDokumen3(Integer dokumen3) {
		this.dokumen3 = dokumen3;
	}

	public Integer getDokumen4() {
		return dokumen4;
	}

	public void setDokumen4(Integer dokumen4) {
		this.dokumen4 = dokumen4;
	}

	public Integer getDokumen5() {
		return dokumen5;
	}

	public void setDokumen5(Integer dokumen5) {
		this.dokumen5 = dokumen5;
	}

	public Integer getDokumen6() {
		return dokumen6;
	}

	public void setDokumen6(Integer dokumen6) {
		this.dokumen6 = dokumen6;
	}

	public Integer getTotalDf() {
		return totalDf;
	}

	public void setTotalDf(Integer totalDf) {
		this.totalDf = totalDf;
	}

	public Double getDfi() {
		return dfi;
	}

	public void setDfi(Double dfi) {
		this.dfi = dfi;
	}

	public Double getIdf() {
		return idf;
	}

	public void setIdf(Double idf) {
		this.idf = idf;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(term);
		if (query == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(query);
		}
		if (dokumen1 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(dokumen1);
		}
		if (dokumen2 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(dokumen2);
		}
		if (dokumen3 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(dokumen3);
		}
		if (dokumen4 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(dokumen4);
		}
		if (dokumen5 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(dokumen5);
		}
		if (dokumen6 == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(dokumen6);
		}
		if (totalDf == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(totalDf);
		}
		if (dfi == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(dfi);
		}
		if (idf == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(idf);
		}
	}
}
