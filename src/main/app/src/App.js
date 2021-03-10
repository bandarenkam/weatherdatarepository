import React, {Component} from 'react';
import WeatherDataTable from "./WeatheDataTable";
import Container from "@material-ui/core/Container";

class App extends Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
            <Container fixed>
                <h1>Weather data collector(test app). Front and back updates every 5 minutes.</h1>
                <WeatherDataTable />
            </Container>
        );
    }

}

export default App;
