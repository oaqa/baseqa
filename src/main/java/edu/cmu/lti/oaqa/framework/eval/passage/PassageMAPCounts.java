package edu.cmu.lti.oaqa.framework.eval.passage;

final class PassageMAPCounts {

	float docavep;

	float psgavep;
	
	float aspavep;
	
	int count;
	
	PassageMAPCounts() {
		this(0, 0, 0, 0);
	}

	PassageMAPCounts(float avep, float psgavep, float aspavep, int num) {
		this.docavep = avep;
		this.psgavep = psgavep;
		this.aspavep = aspavep;
		this.count = num;
	}

	void update(PassageMAPCounts other) {
		docavep += other.docavep;
		psgavep += other.psgavep;
		aspavep += other.aspavep;
		count += other.count;
	}
}