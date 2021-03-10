import React, {Component} from 'react';
import TableContainer from "@material-ui/core/TableContainer";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import Paper from "@material-ui/core/Paper";
import WeatherDataRows from "./WeatherDataRows";

class WeatherDataTable extends Component {
   constructor(props) {
      super(props);
       this.state = {
           weatherData : []
       };
       this.updateAllTheWeatherData = this.updateAllTheWeatherData.bind(this);
   }

    componentDidMount() {
        this.updateAllTheWeatherData();
        setInterval(this.updateAllTheWeatherData,300000 );
    }

    updateAllTheWeatherData() {
        fetch('http://localhost:8080/weatherData')
            .then(response => response.json())
            .then(data => this.setState({weatherData: data}))
    }


   render() {
      var cells = ["Id", "Temperature in celsius","Air humidity" , "Air pressure", "Observation time",
         "Weather description",  "Api source", "City" ];
      return (
          <TableContainer component={Paper}>
             <Table  aria-label="simple table">
                <TableHead>
                   <TableRow>
                    {cells.map( cell => <TableCell align="right">{cell}</TableCell>)}
                   </TableRow>
                </TableHead>
                <TableBody>
                  <WeatherDataRows weatherData = {this.state.weatherData}/>
                </TableBody>
             </Table>
          </TableContainer>
      );
   }
}

export default WeatherDataTable;