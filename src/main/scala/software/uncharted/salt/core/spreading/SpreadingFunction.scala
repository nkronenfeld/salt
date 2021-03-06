/*
 * Copyright 2015 Uncharted Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package software.uncharted.salt.core.spreading

/**
 * Spread a single value over multiple visualization-space coordinates
 *
 * @tparam TC the abstract type representing a tile coordinate. Must feature a
 *            zero-arg constructor.
 * @tparam BC the abstract type representing a bin coordinate. Must feature a zero-arg
 *            constructor and should be something that can be represented in 1 dimension.
 * @tparam T Input data type for bin aggregators
 */
abstract class SpreadingFunction[TC, BC, T]() extends Serializable {

  /**
   * Spread a single value over multiple visualization-space coordinates
   *
   * @param coords the visualization-space coordinates
   * @param value the value to spread
   * @return Seq[(TC, BC, Option[T])] A sequence of tile coordinates, with the spread values
   */
  def spread(coords: Seq[(TC, BC)], value: Option[T]): Seq[(TC, BC, Option[T])]
}
