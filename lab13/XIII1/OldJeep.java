package lab13.XIII1;

public class OldJeep {
	private String data;

	public OldJeep(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		return "OldJeep [data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OldJeep other = (OldJeep) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
}
