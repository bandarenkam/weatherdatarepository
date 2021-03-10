import React, {Component} from 'react';
import WeatherDataRow from "./WeatherDataRow";

class WeatherDataRows extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <>
                    {this.props.weatherData.map((entry) => <WeatherDataRow weatherDataRow = {entry} />) }
              </>
        );
    }
}

export default WeatherDataRows;