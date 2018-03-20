import React, { Component } from 'react';

class ProjectNotes extends Component {
  render() { 
    return (
      <section>
        <div className="tile-heading">
        <h3>Notes</h3>
        </div>
        <textarea rows="4" cols="50"
          onBlur={() => this.props.updateNotes(this.props.projectInView.projectId)}
          onChange={e => this.props.changeNotes(this.props.projectInView.projectId, e.target.value)}
          value={this.props.projectInView.notes || `put notes here`} 
        >
        </textarea>
      </section>
    )
  }
}
 
export default ProjectNotes;