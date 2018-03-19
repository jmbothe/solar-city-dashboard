import React, { Component } from 'react';

class ProjectNotes extends Component {
  render() { 
    return (
      <section>
        <h3>Notes</h3>
        <textarea rows="4" cols="50"
          onBlur={() => this.props.updateNotes(this.props.project.projectId)}
          onChange={e => this.props.changeNotes(this.props.project.projectId, e.target.value)}
        >
          {this.props.project.notes || `put notes here`} 
        </textarea>
      </section>
    )
  }
}
 
export default ProjectNotes;