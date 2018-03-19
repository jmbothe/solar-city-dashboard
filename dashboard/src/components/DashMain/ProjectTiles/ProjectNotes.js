import React, { Component } from 'react';

class ProjectNotes extends Component {
  state = {}
  render() { 
    return (
      <section>
        <h3>Notes</h3>
        <textarea rows="4" cols="50">
          {this.props.notes || `put notes here`} 
        </textarea>
      </section>
    )
  }
}
 
export default ProjectNotes;