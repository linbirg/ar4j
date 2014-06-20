package sge.base.mock;

import sge.base.ar4j.Model;
import sge.base.dao.Column;
import sge.base.dao.Table;

@Table(name="tip_bp_job")
public class TIPBPJob extends Model<TIPBPJob> {
	@Column(pk = true)
	int id;

	@Column
	int status;

	@Column
	String started_at;

	@Column
	String ended_at;

	@Column
	int outcome_id;

	@Column
	String engine_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStarted_at() {
		return started_at;
	}

	public void setStarted_at(String started_at) {
		this.started_at = started_at;
	}

	public String getEnded_at() {
		return ended_at;
	}

	public void setEnded_at(String ended_at) {
		this.ended_at = ended_at;
	}

	public int getOutcome_id() {
		return outcome_id;
	}

	public void setOutcome_id(int outcome_id) {
		this.outcome_id = outcome_id;
	}

	public String getEngine_id() {
		return engine_id;
	}

	public void setEngine_id(String engine_id) {
		this.engine_id = engine_id;
	}
}
