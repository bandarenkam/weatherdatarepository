import React, {Component} from 'react';
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";

class WeatherDataRow extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        const fields =  ["id", "currentTemperatureInCelsius", "airHumidity", "airPressure", "observationTime", "weatherDescription",
                        "apiSource", "city"]
        return (
                   <TableRow key={this.props.weatherDataRow.id} >
                       {fields.map(field => <TableCell align='right'>{this.props.weatherDataRow[field]}</TableCell>)}
                    </TableRow>
        );
    }
}

export default WeatherDataRow;